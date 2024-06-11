class ArrayOperation:
    def __init__(self):
        self._ArrayInput = []
        self._productOfArrayElements = []

    def display_input_array(self) -> list:
        self._ArrayInput = [1, 2, 3, 4, 5, 6, 6]
        return self._ArrayInput

    def find_productOfArrayElemnts(self):
        for i in self._ArrayInput: 
            self._productOfArrayElements.append(self._ArrayInput[i] * 2)
        print(self._productOfArrayElements)

    @staticmethod
    def length(collection):
        collection_counter = 0
        for i in collection:
            collection_counter += 1
        return collection_counter


container = ArrayOperation()
container.find_productOfArrayElemnts()
print(container.length([1, 2, 3, 4, 5, 6, 7, 8]))