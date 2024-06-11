# number_of_rows = 4
# number_of_columns = 5
# tables = []
# for i in range(number_of_rows):
#     col = []
#     for y in range(number_of_columns):
#         product = i * y
#         col.append(product)
#     tables.append(col)
#
# for i in range(4):
#     for x in range(5):
#         print(tables[i][x], end="  ")
#     print("\n")
list_of_numbers = []
for i in range(1, 51):
    list_of_numbers.append(i)


def display_even_numbers_between_1_50(list_of_numbers_x):
    list_of_even_numbers = []
    for x in list_of_numbers_x:
        if x % 2 == 0:
            list_of_even_numbers.append(x)
    print(list_of_even_numbers)


display_even_numbers_between_1_50(list_of_numbers)
