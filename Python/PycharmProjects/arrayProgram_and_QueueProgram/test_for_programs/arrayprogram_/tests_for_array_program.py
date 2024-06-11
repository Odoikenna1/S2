import unittest

from main import ArrayOperation


class MyTestCase(unittest.TestCase):
    # add assertion here
    def test_that_collection_counter_works_for_tuples(self):
        collection = [1, 2, 3, 4, 5, 6, 7, 8]
        length_of_collection_returned = ArrayOperation.length(collection)
        self.assertEqual(length_of_collection_returned, len(collection))

    def test_that_collection_counter_works_for_strings(self):
        collection = "sister"
        length_of_collection_returned = ArrayOperation.length(collection)
        self.assertEqual(length_of_collection_returned, len(collection))

    def test_that_collection_counter_works_for_stringsWithSymbols(self):
        collection = ("apple", "bees", "cup", "knife")
        length_of_collection_returned = ArrayOperation.length(collection)
        self.assertEqual(length_of_collection_returned, len(collection))

    def test_that_collection_counter_works_for_empty_list(self):
        collection = []
        length_of_collection_returned = ArrayOperation.length(collection)
        self.assertEqual(length_of_collection_returned, len(collection))

    def test_that_collection_counter_works_for_empty_string(self):
        collection = ""
        length_of_collection_returned = ArrayOperation.length(collection)
        self.assertEqual(length_of_collection_returned, len(collection))

    def test_that_my_collection_is_empty(self):
        collection = ""
        self.assertEqual(0, len(collection))
