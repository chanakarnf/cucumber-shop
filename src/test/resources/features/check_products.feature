Feature: Check products
    As a customer
    I want to customer products

Background:
    Given ฉันมี ตู้เย็น with ราคา 5000 บาท จำนวน 3
    And ฉันมี เตารีด with ราคา 1000 บาท จำนวน 2
    And ฉันมี เตาอบ with ราคา 3000 บาท จำนวน 5
    And ฉันมี ไมโครเวฟ with ราคา 2500 บาท จำนวน 4



Scenario: Check 3 product
    When ฉันต้องการเช็ค ตู้เย็น with quantity 2
    And ฉันต้องการเช็ค เตาอบ with quantity 1
    And ฉันต้องการเช็ค เตารีด with quantity 2
    Then total should be 15000

Scenario: Check 1 product and quantity is not enough
    When ฉันต้องการเช็ค ตู้เย็น with quantity 5
    Then ไม่สามารถซื้อได้เนื่องจากสินค้าไม่เพียงพอ

Scenario: Check 2 product and quantity is not enough
    When ฉันต้องการเช็ค ตู้เย็น with quantity 5
    And ฉันต้องการเช็ค เตารีด with quantity 2
    Then ไม่สามารถซื้อได้เนื่องจากสินค้าไม่เพียงพอ
