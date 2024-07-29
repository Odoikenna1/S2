from commission_employee import CommissionEmployee


class SalaryEmployee(CommissionEmployee):
    def __init__(self, first_name, last_name, phone, sales, rate, base_salary):
        super().__init__(first_name, last_name, phone, sales, rate)
        self.base_salary = base_salary

    def earnings(self):
        return self.sales * self.rate

    def __str__(self):
        return super().__str__() + "\n Earning: {self.earnings}"
            
