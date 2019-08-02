# Fork/join framework and compareAndSetForkJoinTaskTag()
Write a program that applies fork/join framework to a suite of interdependent tasks that should be executed only once (e.g. task D depends on task C and B, but, task C depends on task B as well, therefore task B must be executed only once, not twice).
