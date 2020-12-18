import math as m

lines = open("Day5Input.txt").read().split()

for line in lines:
    lower_range = 0
    upper_range = 127
    col_low = 0
    col_high = 7
    for i in range(7):
        if line[i] == 'F':
            upper_range -= m.floor((upper_range - lower_range) / 2)
        elif line[i] == 'B':
            lower_range += m.ceil((upper_range - lower_range) / 2)
    for i in range(3):
        if line[i] == 'R':
            col_