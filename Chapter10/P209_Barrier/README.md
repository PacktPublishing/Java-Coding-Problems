# Barrier
Write a program that relies on **CyclicBarrier** to simulate the start process of a server. The server is considered started after its internal services has started. Services can be prepared for start concurrently (this is time-consuming), but they run interdependent, therefore, once they are ready to start, they must be started all at once.
