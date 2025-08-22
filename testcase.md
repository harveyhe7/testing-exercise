# 创建账户场景
## 正常创建账户情况
### 创建一个新账户
Task1
- Given: id, and initial positive balance.
- When: call AccountService to create a new account. call Account.getID
- Then: get the new account id

Task2
- Given: id, and initial 0 balance.
- When: call AccountService to create a new account. call Account.getID
- Then: get the new account id

## 特殊账户情况
### 创建一个账户，id为null
Task3
- Given: null id, and initial positive balance.
- When: call AccountService to create a new account.
- Then: An exception should be thrown indicating invalid account ID.

### 创建一个账户，id为 isBlank（）
Task4
- Given: isBlank() id, and initial positive balance.
- When: call AccountService to create a new account.
- Then: An exception should be thrown indicating invalid account ID.

### 创建一个账户，余额为负数
Task5
- Given: id, and initial negative balance.
- When: call AccountService to create a new account.
- Then: An exception should be thrown indicating invalid initial balance.



# 转账场景
## 正常转账情况
### 两个账户余额均为正，转账金额小于余额
Task1
- Given: A account with a balance of 1000. B account with a balance of 500.
- When: Transfer 200 from A to B.
- Then: A's balance should be 800, B's balance should be 700. Total balance should remain 1500.

### 两个账户余额均为正，转账金额等于余额
Task2
- Given: A account with a balance of 1000. B account with a balance of 500.
- When: Transfer 1000 from A to B.
- Then: A's balance should be 0, B's balance should be 1500. Total balance should remain 1500.

## 特殊金额情况
### 两个账户余额均为正，转账金额大于余额 
Task3
- Given: A account with a balance of 1000. B account with a balance of 500.
- When: Transfer 1200 from A to B.
- Then: An exception should be thrown indicating insufficient funds. Total balance should remain 1500.

### 两个账户余额均为正，转账金额为负
Task4
- Given: A account with a balance of 1000. B account with a balance of 500.
- When: Attempt to transfer -100 from A to B.
- Then: An exception should be thrown indicating invalid transfer amount. Total balance should remain 1500.

### 两个账户余额均为正，转账金额为0
Task5
- Given: A account with a balance of 1000. B account with a balance of 500.
- When: Attempt to transfer 0 from A to B.
- Then: A's balance should remain 1000, B's balance should remain 500. Total balance should remain 1500.

## 特殊账户情况
### 转账没有源账户，有目标账户
Task6
- Given: No source account, B account with a balance of 500.
- When: Attempt to transfer 100 from non-existent A to B.
- Then: An exception should be thrown indicating no source account. B's balance should remain 500.

### 转账没有目标账户，有源账户
Task7
- Given: A account with a balance of 1000, no destination account.
- When: Attempt to transfer 100 from A to non-existent B.
- Then: An exception should be thrown indicating no destination account. A's balance should remain 1000.

### 转账没有源账户和目标账户
Task8
- Given: No source account, no destination account.
- When: Attempt to transfer 100 from non-existent A to non-existent B.
- Then: An exception should be thrown indicating no source and destination accounts. 






