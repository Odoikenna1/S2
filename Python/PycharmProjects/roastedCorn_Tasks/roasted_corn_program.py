from typing import List, Any, Set


class RoastedCorn:
    def __init__(self):
        self.lst_of_numbers_one_fifty = []

    def create_list_of_integer(self):
        self.lst_of_numbers_one_fifty = [number for number in range(1, 51)]
        return self.lst_of_numbers_one_fifty

    # @staticmethod
    def find_length(self, your_lst):
        length_of_your_lst = 0
        for index in your_lst:
            length_of_your_lst += 1
        return length_of_your_lst

    # @staticmethod
    def sum_elements_at_even_index(self) -> int:
        values = list(range(1, 51))
        sum_of_numbers_at_even_index = sum(values[::2])
        return sum_of_numbers_at_even_index

    def sum_elements_at_even_index_without_slicing(self):
        self.lst_of_numbers_one_fifty = [number for number in range(1, 51)]
        result = 0
        for index in range(len(self.lst_of_numbers_one_fifty)):
            if index % 2 == 0:
                result += self.lst_of_numbers_one_fifty[index]
        return result

    def sum_elements_at_even_index_without_slicing(self):
        self.lst_of_numbers_one_fifty = [number for number in range(1, 51)]
        result = 0
        for index in range(len(self.lst_of_numbers_one_fifty)):
            if index % 2 == 0:
                result += self.lst_of_numbers_one_fifty[index]
        return result

    def sum_elements_at_odd_index(self, your_lst) -> int:
        sum_of_elements_at_ood_index = 0
        if not your_lst:
            return 0
        for index in range(len(your_lst)):
            if index % 2 != 0:
                sum_of_elements_at_ood_index += your_lst[index]
        return sum_of_elements_at_ood_index

    def find_product_of_elements_at_every_third_position(self, your_lst) -> int:
        product = 1
        if not your_lst:
            return 0
        for index in range(len(your_lst)):
            if index % 3 == 0:
                product *= your_lst[index]
        return product

    def find_average_of_elements_in_lst(self, your_lst):
        product = 1
        if not your_lst:
            return 0
        else:
            total_number_of_elements = self.find_length(your_lst)
        sum_of_elements = sum(your_lst[::])
        return sum_of_elements / total_number_of_elements

    def find_smallest(self, lst_elements) -> int:
        smallest_num = lst_elements[0]
        for index in range(len(lst_elements)):
            if smallest_num > lst_elements[index]:
                smallest_num = lst_elements[index]
        return smallest_num

    def find_largest(self, lst_elements) -> int:
        largest_num = lst_elements[0]
        for index in range(len(lst_elements)):
            if lst_elements[index] > largest_num:
                largest_num = lst_elements[index]
        return largest_num

    def find_length_of_string_in_list_of_strings(self) -> Any:
        word_lst = ["john", "madam", "sk", "Kenya", "Ghana"]
        lst_of_word_count_for_each_string = []
        for lst_index in range(len(word_lst)):
            for word_index in range(len(word_lst[lst_index])):
                word_length_count = len(word_lst[lst_index])
            lst_of_word_count_for_each_string.append(word_length_count)
        return lst_of_word_count_for_each_string

    def construct_and_display_lst(self) -> List:
        lst_of_numbers = []
        for i in range(1, 16):
            lst_of_numbers.append(i)
        return lst_of_numbers

    def duplicate_lst(self) -> List:
        lst_of_numbers = self.construct_and_display_lst()
        temp = []
        temp = lst_of_numbers
        return temp + lst_of_numbers

    def remove_duplicate_elements(self) -> set[Any]:
        # cleaned_set = set()
        cleaned_set = set(self.duplicate_lst())
        return cleaned_set

    def add_every_third_element_in_a_given_lst(self):
        given_lst = self.construct_and_display_lst()
        summed_values = []
        for i in range(1, len(given_lst), 3):
            x = given_lst[i]+given_lst[i]
            summed_values.append(x)
        return summed_values



# print(create_list_of_integer())
# print(find_length(["Adam", "Eve", "Kain", "Able", "Ruth", "Sir Sk"]))
