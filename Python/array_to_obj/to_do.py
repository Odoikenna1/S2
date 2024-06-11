def array_to_obj():
    items = [2, 3, 5, 3, 3, 2, 5]
    new_collection = {}
    # first_element = self.items[0]
    for counter in items:
        new_collection[counter] = new_collection.get(counter, 0) + 1
    return new_collection

