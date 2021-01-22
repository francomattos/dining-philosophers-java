# Java - Dining Philosophers

Java concurrent processing example with Dining Philosophers, created to avoid deadlocks.

This example creates 5 Philosophers and 5 forks.

The code execudes the following logic for each philosopher, as per the problem described on its [Wikipedia Page][wiki].

- think until the left fork is available; when it is, pick it up;
- think until the right fork is available; when it is, pick it up;
- when both forks are held, eat for a fixed amount of time;
- then, put the right fork down;
- then, put the left fork down;
- repeat from the beginning

[wiki]: https://en.wikipedia.org/wiki/Dining_philosophers_problem
