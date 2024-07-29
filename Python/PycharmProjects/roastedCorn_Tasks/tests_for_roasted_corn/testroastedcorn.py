import unittest

from PycharmProjects.roastedCorn_Tasks.roasted_corn_program import RoastedCorn


class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.function_identifier = RoastedCorn()

    def test_function_that_creates_list_of_numbers_from_one_to_fifty(self):
        result = self.function_identifier.create_list_of_integer()
        self.assertEqual([number for number in range(1, 51)], result)

    def test_function_that_returns_the_length_of_a_list(self):
        your_lst = self.function_identifier.create_list_of_integer()
        length_of_your_lst = self.function_identifier.find_length(your_lst)
        self.assertEqual(len(your_lst), length_of_your_lst)

    def test_sum_of_even_numbers_function(self):
        sum_value = self.function_identifier.sum_elements_at_even_index()
        self.assertEqual(625, sum_value)

    def test_sum_elements_at_even_index_without_slicing(self):
        sum_value = self.function_identifier.sum_elements_at_even_index_without_slicing()
        self.assertEqual(625, sum_value)

    def test_sum_elements_at_odd_index_without_slicing(self):
        lst_elements = self.function_identifier.create_list_of_integer()
        self.assertEqual(650, self.function_identifier.sum_elements_at_odd_index(lst_elements))

    def test_product_of_elements_at_third_index_function(self):
        lst_elements = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        result = self.function_identifier.find_product_of_elements_at_every_third_position(lst_elements)
        self.assertEqual(280, result)

    def test_average_of_elements_in_lst(self):
        lst_elements = self.function_identifier.create_list_of_integer()
        average = self.function_identifier.find_average_of_elements_in_lst(lst_elements)
        self.assertEqual(25.5, average)

    def test_find_smallest_number_in_lst(self):
        lst_elements = self.function_identifier.create_list_of_integer()
        smallest_num_in_lst = self.function_identifier.find_smallest(lst_elements)
        self.assertEqual(1, smallest_num_in_lst)

    def test_find_largest_number_in_lst(self):
        lst_elements = self.function_identifier.create_list_of_integer()
        largest_num_in_lst = self.function_identifier.find_largest(lst_elements)
        self.assertEqual(50, largest_num_in_lst)

    def test_find_length_of_string_in_list_of_strings(self):
        result = self.function_identifier.find_length_of_string_in_list_of_strings()
        self.assertEqual([4, 5, 2, 5, 5], result)

    def test_that_construct_and_display_lst(self):
        result = self.function_identifier.construct_and_display_lst()
        self.assertEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], result)

    def test_duplicate_lst_function(self):
        result = self.function_identifier.duplicate_lst()
        self.assertEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], result)

    def test_duplicate_removed(self):
        result =  self.function_identifier.remove_duplicate_elements()
        self.assertEqual({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, result)

    def test_add_every_third_element_in_a_given_lst(self):
        result = self.function_identifier.add_every_third_element_in_a_given_lst()
        self.assertEqual([4, 10, 16, 22, 28], result)
if __name__ == '__main__':
    unittest.main()
