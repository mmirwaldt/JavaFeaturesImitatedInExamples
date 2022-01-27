# Java features imitated in examples

### Table of contents

* [What is this?](#what-is-this)
* [Why are some Java features hard to understand?](#why-are-some-java-features-hard-to-understand)
* [Why is similar code useful?](#why-is-similar-code-useful)
* [Why are the javadoc comments sometimes not enough?](https://github.com/mmirwaldt/JavaFeaturesImitatedInExamples#why-are-the-javadoc-comments-sometimes-not-enough)
* [Why is the word "imitated" and not "emulated" used in the name of this project?](#why-is-the-word-imitated-and-not-emulated-used-in-the-name-of-this-project)
* [How do the examples look like?](#how-do-the-examples-look-like)
* [Why are explaining comments missing in the examples?](#why-are-explaining-comments-missing-in-the-examples)
* [Which Java features are covered by this project?](#which-java-features-are-covered-by-this-project)
* [Why do some examples have got small numbers and other ones larger ones in their names?](#why-do-some-examples-have-got-small-numbers-and-other-ones-larger-ones-in-their-names)
* [What if the projects has grown to 999 examples for one module?](#what-if-the-projects-has-grown-to-999-examples-for-one-module)
* [What shall you do if you discover an error?](#what-shall-you-do-if-you-discover-an-error)
* [What shall you do if you miss an example?](#what-shall-you-do-if-you-miss-an-example)
* [What shall you do if you dislike this project?](#what-shall-you-do-if-you-dislike-this-project)
* [How can you say thank you?](#how-can-you-say-thank-you)
* [Who owns the copyright for this project?](#who-owns-the-copyright-for-this-project)
* [How is this project licensed?](#how-is-this-project-licensed)

### What is this?

This project wants to help Java developers to understand some Java features by examples with similar code. These
examples show how these features can be used **and** offers similar code in order to explain how those features work.
The similar code is very simple because it only needs to cover the scenario in the example. Variables, if-clauses,
for-loops and sub methods are often enough for that. The similar code

* **only imitates** the imitated code.
* **does not emulate** the imitated code.
* is **always only an approximation** of the imitated code.
* **never considers or covers all details of the actual implementation** of the imitated code.
* focuses only on the scenario in the example. It ignores all other scenarios.
* cannot be used to make any assumptions about the performance or any other characteristics of the imitated code.

### Why are some Java features hard to understand?

Everybody can read the code in the jdk because it is largely open source. However, understanding that code can be very
difficult because

* it is a lot of code with many small but important implementation details.
* it introduces new elements from other programming paradigms like Lambdas and Streams from functional programming.
* it adds new concepts like CompletableFutures for concurrency.
* it is very tricky because it must run fast and be safe.
* it has become complicated because it must be very flexible and backwards compatible.

Some new features might overwhelm some developers before these developers get familiar with those features.

### Why is similar code useful?

Similar code can be useful because

* it can focus on one use case for a feature in one example.
* it can ignore some implementation details.
* it doesn't need to be fast nor safe nor flexible nor backwards compatible.
* it can point out the strengths of a feature.
* it can show how many lines of codes must not be written when one feature is used.

Similar code can be considered as a translation of imitated code into code with which many developers feel familiar.

### Why are the javadoc comments sometimes not enough?

Of course, the javadoc comments e.g. for the openjdk are great and tell developers a lot about how some Java features
can be used. They are always worth being read carefully! However, they are extensive documentation and not code.
Sometimes they even provide some small code snippets and that is very good. They always lack working example code which
is too much for javadoc comments though. Many Java features can be used in many contexts so that listing them all is
impossible.

### Why is the word "imitated" and not "emulated" used in the name of this project?

If you look up the different meanings of the words "imitate" and "emulate", you will find this explanation:

* Emulate means "to try to be as good or successful as."
* Imitate means "to copy or fashion oneself after."

Source: https://www.grammarbook.com/homonyms/emulate-imitate.asp <br/>

The similar code in this project **never tries to be as good** as the code it imitates. The similar code only seeks for
the same effect or result of the imitated code.

### How do the examples look like?

Every example has got a name which indicates which feature(s) is/are demonstrated. Moreover, it has got a main-method
which can be executed to run the example. The main-method has got two sections which start with a comment. The comment
is either "// with <feature>" or "// without <feature>". E.g. the stream examples have got the comments "// with stream"
and  "// without stream". All examples write something to the console and can be executed without any parameters. Either
they write their outputs directly to the console or they return results which are printed out in the console. The two
outputs are usually the same and they are separated by a line of many "-" chars for better readability.

### Why are explaining comments missing in the examples?
The similar code is considered as the explanation for one example. Useless comments would be rather noisy than helpful.
Moreover, the javadocs for many classes and methods in the jdk are very good and extensive.
Look to them if you look for more explanations and insights.
Furthermore, good comments tell you **why** one solution was chosen and **not how** it works.
Code must always be written in a way that it tells you what it does without the help of any additional comments.
I must confess I have mostly got no idea why the jdk developers have decided in favour of one solution or against it.
Therefore, I neither want to speculate nor make any wrong assumptions about those reasons in comments.

### Which Java features are covered by this project?

Every maven module in this project covers one Java feature. The current features are

* Streams
* Completable futures

Others will follow soon.

### Why do some examples have got small numbers and other ones larger ones in their names?

Easy examples tend to have a smaller number wile sophisticated ones prefer to use larger ones. This is intentional
because beginners can start with the first examples while professionals can begin with the last examples. However, it
leads to a gap between those two. Don't get confused by that. It can't be avoided because some numbers must be reserved
for new examples. New examples fill the gap. Moreover, examples don't become more difficult with rising numbers because
rearranging all examples all the times must be avoided if another example is added. Easy examples are appended after the
first examples while sophisticated examples are added before the last examples though. The author of this project
decides whether an example is easy or sophisticated.

### What if the projects has grown to 999 examples for one module?

Let's see whether we really find so many good examples ... I have got my doubts.

### What shall you do if you discover an error?

Great feedback is always a present for me. Great feedback is constructive feedback which either gives me a proposal to
improve one example or it inspires me for new ideas. You have got some options:

* You open a ticket in which you tell me why it is very confusing or even wrong. I would be happy if you have got a
  proposal for me.
* You fork this project, change the code and submit me a PR with an explanation. Please add a comment in which you
  clearly pass me your copyright for your code.

**Please don't bother me with stylistic issues or silly name or comment discussions.**
It's a waste of time for me and I am going to ignore it.

### What shall you do if you miss an example?

Please make sure that you have checked these requirements for adding a new example:

* It hasn't been covered by one of the existing examples in order to avoid duplicates
* It must focus on as few features as possible to keep it simple
* It must not be a large program to avoid an abuse of this feature e.g. a stream expression as a program to read out a
  text file and to find the top ten of the most frequently used words.
* Similar code must exist to imitate the code for that feature and not be too complicated.<br/> E.g. writing code for
  parallel stream expressions might be too complicated.
* It must be interesting and relevant, i.e. it must be useful and relevant for many developers because they are likely
  to use it in their projects.
* It can be a bit exotic but not too exotic if it uses a rarely used feature or a very new feature. <br/> E.g. only a
  few developers know the stream method "mapMulti()" which makes it exotic. However, this method can be very useful in
  some edge case and avoid complicated code.

Of course, some criteria might be a bit subjective or arbitrary. I still think most of them are objective *enough* to
judge whether it's worth adding a new example or not.

### What shall you do if you dislike this project?

If you can give me your negative feedback in a constructive way that I can learn something from it, then contact me.
Otherwise, then please just ignore this project and be silent about it!
Your colleagues must have an **unbiased** look on this project on their own and decide whether it's useful for them or
not. Emails with insulting comments are going to be ignored and immediately deleted. Moreover, the sender email address
is going to be blocked.

### How can you say thank you?

You can write me an email if the examples helped you a lot and tell me why shortly. This encourages me to spend enough
time on this project besides all my other projects. And I would like to collect some testimonials. I would love to add
some quotes of users about this project in another file to motivate other developers to look on the examples and use and
run them to gain experience.

### Who owns the copyright for this project?

Michael Mirwaldt owns the copyright (c) for this project since 2021. All rights reserved to him.

### How is this project licensed?

<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a><br />
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons
Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.

