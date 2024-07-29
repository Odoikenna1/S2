class Human:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    @property
    def age(self):
        return self.age

    @age.setter
    def age(self, value):
        self._age = value

