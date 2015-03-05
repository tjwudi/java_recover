# Java Recover

Recover my Java skills ...

### Notes

Garbage collection is not destruction

***

Overload: Same class, diff methods with same name and diff params. Override: Diff class, same method.

***

Q: Why is String class considered immutable?
A: The String class is immutable, so that once it is created a String object cannot be changed. Since String is immutable it can safely be shared between many threads ,which is considered very important for multithreaded programming.

### TODO

1. Regex
2. Multi-threading
3. *Set, *Map, *List ...
4. Encoding

### Others

1. Linux commands

### Question

1. Given a log file with format:
" 1,2,start
2,3,end
2,4, start """"
where each tuple is a (job_id,time,option) where option is start or end, find a way to map concurrent processes to each other