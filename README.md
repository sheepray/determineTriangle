# Project Description
This is a showcase project which takes the length of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene. The main function is called **determineTriangle** in [Utils.java](src/io/ruiyang/Utils.java). A test file which contains all the test cases for this function is named as [UtilsTest.java](test/io/ruiyang/UtilsTest.java).

# Design decision
My target is to build a function (_determineTriangle_) which takes three parameters as input and with fixed return values. By defining an enum _TriangleType_, I can make sure that my function _determineTriangle_ only return fixed values. Since there is no need for extra initializations for the parent class (_Utils_) to use _determineTriangle_, so _determineTriangle_ can comes as a factory method. In this case, to use this function, only one _Utils_ class has to be instantiated. To provide convenience to call _determineTriangle_, I add another overload function which takes different parameters with the same functionality.

# Function Main Logic

The conditions for three sides to form a triangle is that:

- the sum of any two sides is bigger than the third one;
- the absolute value of subtraction of any two sides is smaller than the third one.

(More about triangle in [Wikipedia](https://en.wikipedia.org/wiki/Triangle))

Firstly I sort the input sides in an ascending order _( a <= b <= c )_. To determine whether these sides can form a triangle or not , the only thing I need to check is the sum of two smaller sides _(a + b)_  is bigger than the third one _( c )_. To avoid sum calculation overflow, the formulation came to be _( a > c - b )_.

# How to test the project
You can clone this repo and import it as a project to Eclipse or Android Studio.

# Function usage example

```java
	Utils.determineTriangle(a, b, c);
```
or
```java
	Utils.determineTriangle(new BigDecimal[]{a, b, c});
```

# TODO:
adding support for different building system.
