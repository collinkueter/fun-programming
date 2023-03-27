# Review: Mathematical Functions

<br>
A function from a set `X` to a set `Y` is an assignment of an element of `Y` to each element of `X`.
- The set X is called the domain of the function
- The set Y is called the codomain of the function.

Represented as:
$$
\begin{aligned}
\operatorname {f} (x)=x+1 \\
(x)\mapsto x+1 \\
\operatorname {f} \colon \mathbb {Z} &\to \mathbb {Z} \\
\newline
\operatorname {f}(5) = 5 + 1 = 6
\end{aligned}
$$

<!-- 
In programming functions can update a database, mutate some variables, do nothing, throw exceptions, etc.

Mathematical function always evaluate to the same thing given the same input

Mathematical functions are a thing, values that you can manipulate

We want to borrow this same concept which makes our functions act the same

so we create rules to make them act the same 

We call these Pure Functions or function which have no side effects

We define the following rules
total – defined for every input. For example, String#toInt is not total because it’s not defined for any String input like “foo”.
deterministic – the same input always gives the same output. Random#nextInt(100) is not deterministic because when we call it two times, we’re gonna get 2 different results.
pure – without side effects, with the only concern of computing the result. The side effects can be anything from console logging to calling external API.

-->