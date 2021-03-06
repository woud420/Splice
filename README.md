Splice
==================
Splice is a library that helps with creation and execution of genetic algorithms.

I have developed it sometime ago because of a project that had very long and costly fitness functions and the libraries
that I used took too long for evaluation.

With this in mind I began to make a library that could run those functions in a reasonable amount of time.

Even though now I have put some aids to improve the GA's development process, I still keep the performance in mind.

Building
==================
Currently Splice requires Java 7 to be compiled and run.
Apart from that I try to keep it free of other libraries dependencies.
If you want to build from the shell you will need to have gradle configured in your machine.

To do that in a terminal session, change to the project root and run:

```
$ gradle build
```

There are also project config files for Eclipse and Intellij IDEA so you are able to open the project and edit it in these
IDEs.

Samples
==================
Look for samples/ folder to see how to build simple genetic algorithms.

Samples included:

* samples/nqueens/: it solves the N-Queens problem
* samples/zeros/: evolves a list of integers until its values are all zeros
* samples/rosenbrock: minimization of bi-dimensional rosenbrock function

Contributing
==================
You are free to fork and make pull requests for any feature that you may think is worth to be in the library.

License
==================
The MIT license is included along with this file.
