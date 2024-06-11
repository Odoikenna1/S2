import unittest

from array_to_obj import to_do


class MyTestCase(unittest.TestCase):
    def test_that_array_to_object_works(self):
        result = {2: 2, 3: 3, 5: 2}
        self.assertEqual(result, to_do.array_to_obj())  # add assertion here


if __name__ == '__main__':
    unittest.main()
