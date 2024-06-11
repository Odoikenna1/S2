import unittest

from class_on_queue import MyQueue

class MyTestCase(unittest.TestCase):
    def test_that_queue_length_function_works(self):
        newQueue = MyQueue()
        items = 1, 2, 5, 8, 10
        self.assertEqual(5, newQueue.length(items))

    def test_that_join_queue_function_works(self):
        newQueue = MyQueue()
        one_item = 5
        newQueue.join(one_item)
        self.assertEqual(1, newQueue.lengthof())

    def test_that_more_than_one_item_can_join_queue(self):
        newQueue = MyQueue()
        item1 = 7, 8, 10, 2, 4
        item2 = "sandy"
        item3 = 8
        newQueue.join(item1, item2, item3)
        self.assertEqual(3, newQueue.lengthof())

    def test_that_queue_bounce_can_take_out_only_first_element(self):
        newQueue = MyQueue()
        item1 = 7, 8, 10, 2, 4
        item2 = "sandy"
        item3 = 8
        newQueue.join(item1, item2, item3)
        result = [(7, 8, 10, 2, 4), "sandy", 8]
        self.assertEqual(result, newQueue.enumerate())

    def test_that_first_element_to_join_queue_can_be_found(self):
        newQueue = MyQueue()
        item1 = 7, 8, 10, 2, 4
        item2 = "sandy"
        item3 = 8
        newQueue.join(item1, item2, item3)
        result = (7, 8, 10, 2, 4)
        self.assertEqual(result, newQueue.find_first_on_queue())

    def test_that_first_element_on_the_queue_can_be_removed(self):
        newQueue = MyQueue()
        item1 = 7, 8, 10, 2, 4
        item2 = "sandy"
        item3 = 8
        newQueue.join(item1, item2, item3)
        result = ["sandy", 8]
        self.assertEqual(result, newQueue.remove_first_on_queue())


if __name__ == '__main__':
    unittest.main()
