from typing import Union


class MyQueue:
    def __init__(self):
        self.queue = []

    def length(self, items) -> int:
        counter = 0
        for i in items:
            counter += 1
        return counter

    def lengthof(self) -> int:
        length_found = self.length(self.queue)
        return length_found

    def join(self, *args):
        self.queue += args

    def enumerate(self) -> Union[int, str, list, any]:
        items_in_queue = self.queue
        for index in items_in_queue:
            return items_in_queue

    def find_first_on_queue(self) -> Union[int, str, list, any]:
        items_in_queue = self.queue
        item_in_queue_at_first_index = items_in_queue[0]
        return item_in_queue_at_first_index

    def remove_first_on_queue(self) -> Union[int, str, list, any]:
        items_in_queue = self.queue
        items_in_queue = items_in_queue[1:]
        return items_in_queue
