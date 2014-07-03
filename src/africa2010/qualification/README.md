Google Code Jam - Qualification Round Africa 2010
=================================================

## Problem A. Store Credit
### Problem
You receive a credit *C* at a local store and would like to buy two items. You first walk through the store and create a 
list *L* of all available items. From this list you would like to buy two items that add up to the entire value of the 
credit. The solution you provide will consist of the two integers indicating the positions of the items in your list 
(smaller number first).

### Input
The first line of input gives the number of cases, *N*. *N* test cases follow. For each test case there will be:

One line containing the value *C*, the amount of credit you have at the store.
One line containing the value *I*, the number of items in the store.
One line containing a space separated list of *I* integers. Each integer *P* indicates the price of an item in the 
store. 

Each test case will have exactly one solution.

### Output
For each test case, output one line containing "Case #x: " followed by the indices of the two items whose price adds up 
to the store credit. The lower index should be output first.

### Limits
5 ≤ *C* ≤ 1000
1 ≤ *P* ≤ 1000

### Small dataset
*N* = 10
3 ≤ *I* ≤ 100

### Large dataset
*N* = 50
3 ≤ *I* ≤ 2000

### Sample

Input 

    3
    100
    3
    5 75 25
    200
    7
    150 24 79 50 88 345 3
    8
    8
    2 1 9 4 4 56 90 3

Output

    Case #1: 2 3
    Case #2: 1 4
    Case #3: 4 5

## Problem B. Reverse Words

### Problem
Given a list of space separated words, reverse the order of the words. Each line of text contains *L* letters and *W* 
words. A line will only consist of letters and space characters. There will be exactly one space character between 
each pair of consecutive words.

### Input
The first line of input gives the number of cases, *N*.
*N* test cases follow. For each test case there will a line of letters and space characters indicating a list of space 
separated words. Spaces will not appear at the start or end of a line.

### Output
For each test case, output one line containing "Case #x: " followed by the list of words in reverse order.

### Limits
None.

### Small dataset
*N* = 5
1 ≤ *L* ≤ 25

### Large dataset
*N* = 100
1 ≤ *L* ≤ 1000

### Sample
Input 

    3
    this is a test
    foobar
    all your base

Output

    Case #1: test a is this
    Case #2: foobar
    Case #3: base your all
    
## Problem C. T9 Spelling

### Problem
The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. We would like to make it 
easier to write a message to your friend using a sequence of keypresses to indicate the desired characters. The 
letters are mapped onto the digits as shown below. To insert the character B for instance, the program would press 22. 
In order to insert two characters in sequence from the same key, the user must pause before pressing the key a second 
time. The space character ' ' should be printed to indicate a pause. For example, 2 2 indicates AA whereas 22 
indicates B.

![T9 Spelling image] (T9.png)

### Input
The first line of input gives the number of cases, *N*. *N* test cases follow. Each case is a line of text formatted as

    desired_message
    
Each message will consist of only lowercase characters a-z and space characters ' '. Pressing zero emits a space.

### Output
For each test case, output one line containing "Case #x: " followed by the message translated into the sequence of 
keypresses.

### Limits
1 ≤ *N* ≤ 100.

### Small dataset
1 ≤ length of message in characters ≤ 15.

### Large dataset
1 ≤ length of message in characters ≤ 1000.

### Sample
Input

    4
    hi
    yes
    foo  bar
    hello world

Output

    Case #1: 44 444
    Case #2: 999337777
    Case #3: 333666 6660 022 2777
    Case #4: 4433555 555666096667775553