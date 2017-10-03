bitcoin4s
=========
[![Build Status](https://travis-ci.org/liuhongchao/bitcoin4s.svg?branch=master)](https://travis-ci.org/liuhongchao/bitcoin4s)

Scala library for experimenting with Bitcoin

# How to use

Add the following to your build.sbt

```
libraryDependencies += "me.hongchao" %% "bitcoin4s" % "0.0.1"
```

with the following resolver

```
resolvers += Resolver.bintrayRepo("liuhongchao", "maven")
```

# Parse Bitcoin script

```
scala> import me.hongchao.bitcoin4s.script.Parser
import me.hongchao.bitcoin4s.script.Parser

scala> Parser.parse("0 IF 0 ELSE 1 ELSE 0 ENDIF")
res0: Seq[me.hongchao.bitcoin4s.script.ScriptElement] = List(OP_0, OP_IF, OP_0, OP_ELSE, OP_1, OP_ELSE, OP_0, OP_ENDIF)
```

# Run interpreter

```
val initialState = InterpreterState(
  script = Seq(OP_0, OP_IF, OP_0, OP_ELSE, OP_1, OP_ELSE, OP_0, OP_ENDIF),
  flags = Seq(ScriptFlag.SCRIPT_VERIFY_STRICTENC),
  transaction = spendingTx,
  inputIndex = 0,
  scriptPubKey = Seq(OP_0),
  sigVersion = SigVersion.SIGVERSION_BASE
)

Interpreter.interpret().run(initialState) match {
  case Right((finalState, result)) =>
    ???
  case Left(error) =>
    ???
}

```