# Project Description
This is a showcase project which takes the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene. The main function is called **determineTriangle** in [Utils.java](src/io/ruiyang/Utils.java). A test file which contains all the test cases for this function is named as [UtilsTest.java](src/io/ruiyang/UtilsTest.java).

# Design decision
My target is to build a function (_determineTriangle_) which takes three parameters as input and with fixed return values. By defining a enum _TriangleType_, I can make sure that my function _determineTriangle_ only return fixed values. Since there is no need for extra initializations for the parent class (_Utils_) to use _determineTriangle_, it can comes as a factory method. In this case, to use this _determineTriangle_ function, only one _Utils_ class has to be instantiated. To provide convenience to call _determineTriangle_, I add another overload function which takes different parameters with the same functionality.

The conditions for three sides to form a triangle is that:

- the sum of any two sides is bigger than the third one;
- the absolute value of subtraction of any two sides is smaller than the third one.

(More about triangle in [Wikipedia](https://en.wikipedia.org/wiki/Triangle))

# How to the project
You can clone this repo and import it as a project to Eclipse or Android Studio.

# Function usage example

```java
	Utils.determineTriangle(a, b, c);
```
or
```java
	Utils.determineTriangle(new double[]{a, b, c});
```

# TODO:
More overload functions which accept other primitive type arrays.