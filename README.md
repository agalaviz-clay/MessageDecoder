# Message Decoder
Given a text file with an encoded message, the program will process it and then print out the decoded message to the console.

### Detail
The text file contains a list of number and word in the format:
```text
2 hello
3 is
5 there
1 this
4 world
6 fun
```
There is an arbitrary number of entries in the file. The program first creates a key-value map of the number to its corresponding
string, then it decodes the message by extracting the string value where the first key starts at 1 then follows the pattern where
the next key is the previous key + 1, which is depicted as the below formula:

<img src="https://latex.codecogs.com/gif.latex? String(k) = \frac{(k+2)(k+3)}{2}" /> 

Then, it appends each string value to a result string to be printed out to the console.

For the sample text file above, it would extract the following key-value pairs from the map: `{1, this}, {3, is}, {6, fun}` where the
key is a number following the triangular pattern of: 1, 3, 6, 10, 15, etc.

The final printed output would be: `this is fun`

## How to Run
1) Run the file by compiling it first with `javac MessageDecoder.java`
2) Execute the output bytecode with `java MessageDecoder secret_messages.txt`
