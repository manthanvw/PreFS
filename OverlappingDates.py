'''
Ram and Sita are subscribed to a travel service for their respective 
business commitments in Rome.

You are provided with four subscription strings, startOfRam, 
endOfRam, startOfSita, and endOfSita. 
Ram's subscription allows him to be in the city from the dates 
startOfRam to endOfRam(inclusive), while Sita's subscription
covers the period from startOfSita to endOfSita (inclusive). 

Each subscription date is represented as a 5-character string in 
the format "MM-DD", indicating the month and day of the date.

Your task is to determine the total number of days when 
they can enjoy their Rome experience together.

Assume that all subscription dates fall within the same calendar year, 
which is not a leap year. Note that the number of days per month 
can be represented as: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].

Input Format:
-------------
4 space separated strings, startOfRam, endOfRam, startOfSita, and endOfSita. 

Output Format:
-------------
An integer result.


Sample Input-1:
----------------
08-15 08-18 08-16 08-19

Sample Output-1:
----------------
3

Explanation: 
------------
Ram will be in Rome from August 15 to August 18. 
Sita will be in Rome from August 16 to August 19. 
They both in Rome together on August 16th, 17th, and 18th, 
so the answer is 3.


Sample Input-2:
----------------
10-01 10-31 11-01 12-31

Sample Output-2:
----------------
0



Write your python code below
'''
dates = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
input = input()
ramS,ramE,sitaS,sitaE = input.split(" ") 
ramS,ramE= list(map(int,ramS.split("-"))),list(map(int,ramE.split("-")))
sitaS,sitaE = list(map(int,sitaS.split("-"))),list(map(int,sitaE.split("-")))
ramS,ramE = sum(dates[:ramS[0]-1])+ramS[1],sum(dates[:ramE[0]-1])+ramE[1]
sitaS,sitaE = sum(dates[:sitaS[0]-1])+sitaS[1],sum(dates[:sitaE[0]-1])+sitaE[1]
sd=0
ed=0
s=0
e=0
if(ramS,sitaS):
    sd = ramS
    ed = ramE
    s = sitaS
    e = sitaE
else:
    sd = sitaS
    ed = sitaE
    s = ramS
    e = ramE
i = sd
count = 0
while(i<=ed and i<=e):
    # print(i)
    if(i>=s):
        count+=1
    if(i>e): break
    i+=1
print(count)
