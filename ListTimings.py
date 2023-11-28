'''
Bindu is passionated about clocks.
She found a digital clock, which has 2 rows of led lights,
Top row has 4-leds OOOO indicates hours (0-11).
Bottom row has 6-leds OOOOOO indicates minutes(0-59).
Where O -> led is OFF and * -> led is ON.

For Example: 
If the clock showing the led lights are as follows:
	OO*O indiactes a binary number, 0010 -> 2 hrs
	OO*O** indiactes a binary number, 001011 -> 11 minutes.
So, Time is 2:11

Now, you are given an integer N, number of led lights that are ON.
Your task is to find, all the  possible times in ascending order.

Format of time should be as follows:
	- Hours should not have leading 0's.
	- Minutes should be represented with 2 digits.

Suppose Current time is 1 hous 1 minute
	- Valid time is 1:01
	- Invalid time is as follows:- 01:1, 01:01, 1:1

Input Format:
-------------
An integer N, number of led lights ON.

Output Format:
--------------
Print the list of times in ascending order.


Sample Input:
---------------
1

Sample Output:
----------------
[0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]


Write your python code below
'''
def getHour(n):
    arr = []
    for i in range(0,12):
        for j in range(0,60):
            ans = ""
            if(bin(i).count('1')+bin(j).count('1') == n):
                ans+=str(i)+":"
                if(j<10):
                    ans+="0"+str(j)
                else:
                    ans+=str(j)
                arr.append(ans)
    return arr
def getTime(n):
    arr = []
    for i in range(0,12):
        for j in range(0,60):
            if(bin(i).count('1')+bin(j).count('1') == n):
                arr.append(f"{i}:{j:02d}")
    return arr
on = int(input())
# print(getHour(on))
print(getTime(on))


