Feature: Buy a lot of products
Background:
    Given เรามีสินค้าเหล่านี้
    | เตารีด    | 1000  |
    | ตู้เย็น     | 5000  |
    | เตาอบ    | 3000  |
    | ไมโครเวฟ | 2500  |


Scenario: Buy 3 product
    When ฉันซื้อ ตู้เย็น with quantity 2
    And ฉันซื้อ เตาอบ with quantity 1
    And ฉันซื้อ เตารีด with quantity 2
    Then total should be 15000
