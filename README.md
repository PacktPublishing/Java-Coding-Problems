# Java Coding Problems 

<a href="https://www.packtpub.com/programming/java-coding-problems?utm_source=github&utm_medium=repository&utm_campaign="><img src="https://www.packtpub.com/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/9/7/9781789801415-original.jpeg" alt="Java Coding Problems " height="256px" align="right"></a>

This is the code repository for [Java Coding Problems ](https://www.packtpub.com/programming/java-coding-problems?utm_source=github&utm_medium=repository&utm_campaign=), published by Packt.

**Improve your Java Programming skills by solving real-world coding challenges**

## What is this book about?
* Adopt the latest JDK 8 - JDK 13 features in your applications
* Solve cutting-edge problems relating to collections and data structures
* Get to grips with functional-style programming using lambdas
* Perform asynchronous communication and parallel data processing
* Solve strings and number problems using the latest Java APIs
* Become familiar with different aspects of object immutability in Java
* Implement the correct practices and clean code techniques

This book covers the following exciting features:


If you feel this book is for you, get your [copy](https://www.amazon.com/dp/1789801419) today!

<a href="https://www.packtpub.com/?utm_source=github&utm_medium=banner&utm_campaign=GitHubBanner"><img src="https://raw.githubusercontent.com/PacktPublishing/GitHub/master/GitHub.png" 
alt="https://www.packtpub.com/" border="5" /></a>

## Instructions and Navigations
All of the code is organized into folders. For example, Chapter02.

The code will look like the following:
```
public Map<Character, Integer> countDuplicateCharacters(String str) {

   Map<Character, Integer> result = new HashMap<>();
 
   // or use for(char ch: str.toCharArray()) { ... }
   for (int i = 0; i<str.length(); i++) {
      char ch = str.charAt(i);
      result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
   }
   
   return result;
}
```

**Following is what you need for this book:**
If you are a Java developer who wants to level-up by solving real-world problems, then this book is for you. Working knowledge of Java is required to get the most out of this book.

With the following software and hardware list you can run all code files present in the book (Chapter 1-13).
### Software and Hardware List
| Chapter | Software required | OS required |
| -------- | ------------------------------------ | ----------------------------------- |
| 1-13 | JDK | Windows, Mac OS X, and Linux (Any) |

We also provide a PDF file that has color images of the screenshots/diagrams used in this book. [Click here to download it](https://static.packt-cdn.com/downloads/9781789801415_ColorImages.pdf).

### Related products
* Learn Java 12 Programming  [[Packt]](https://www.packtpub.com/in/application-development/learn-java-12-programming?utm_source=github&utm_medium=repository&utm_campaign=) [[Amazon]](https://www.amazon.com/dp/1789957052)

* Java 11 and 12 - New Features  [[Packt]](https://www.packtpub.com/application-development/java-11-and-12-new-features?utm_source=github&utm_medium=repository&utm_campaign=) [[Amazon]](https://www.amazon.com/dp/1789133270)

## Get to Know the Author
**Anghel Leonard**
is a Chief Technology Strategist with more than 20 years of experience in the Java ecosystem. In his daily work, he is focused on architecting and developing Java distributed applications that empower robust architectures, clean code, and high performance. He is also passionate about coaching, mentoring, and technical leadership.

He is the author of several books, videos, and dozens of articles related to Java technologies.

### Suggestions and Feedback
[Click here](https://docs.google.com/forms/d/e/1FAIpQLSdy7dATC6QmEL81FIUuymZ0Wy9vH1jHkvpY57OiMeKGqib_Ow/viewform) if you have any feedback or suggestions.


