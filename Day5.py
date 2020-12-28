import math as m

lines = open("Day5Input.txt").read().split()

for line in lines:
    lower_range = 0
    upper_range = 127
    row = 0
    col_low = 0
    col_high = 7
    column = 0
    seatID = 0
    for i in range(6):
        if line[i] == 'F':
            upper_range -= m.floor((upper_range - lower_range) / 2)
        elif line[i] == 'B':
            lower_range += m.ceil((upper_range - lower_range) / 2)

    if line[6] == 'F':
        row = lower_range
    else:
        row = upper_range

    for i in range(2):
        if line[7 + i] == 'R':
            col_low += m.ceil((col_high - col_low) / 2)
        elif line[7 + i] == 'L':
            col_high -= m.floor((col_high - col_low) / 2)

    if line[9] == 'R':
        column = col_high
    else:
        column = col_low

    seatID = row * 8 + column

    print(line, end = " ")
    print("Row ", row, end=" ")
    print("Col: ", column, end=" ")
    print("seatID: ", seatID)