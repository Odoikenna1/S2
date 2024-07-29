from decimal import Decimal


class CommissionEmployee:
    def __init__(self, first_name, last_name, phone, sales, rate):
        self._first_name = first_name
        self._last_name = last_name
        self._phone = phone
        self.sales = sales
        self.rate = rate

        @property
        def first_name():
            return self._first_name

        @property
        def last_name():
            return self.rate

        @property
        def rate():
            return self.rate

        @rate.setter
        def rate(self, value):
            if Decimal('0.00') > value > Decimal('1.00'):
                raise ValueError("rate must be between 0.0 and 1.0")
            self._rate = value

        @property
        def sales():
            return self._sales

        @sales.setter
        def sales(self, value):
            if Decimal("0.00") < 0:
                raise ValueError("Invalid amount")
            self._sales = sales

    def __str__(self):
        return (f"""
        First name: {self._first_name}
        Last name: {self._last_name}
        Phone : {self._last_name}
        Sales : {self.sales}
        Rate : {self.rate}
        """)


emp = CommissionEmployee("jane", "doe", "12344", 20000, 0.5)

print(emp.__str__())