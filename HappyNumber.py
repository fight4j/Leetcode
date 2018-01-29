class Solution:
    # @param {integer} n
    # @return {boolean}
    
    def isHappy(self, n):
        if n <= 0:
            return False

        ret = 0
        testNum = n
        wrongNum = []
        
        while (ret != 1):
            numberList = []
            while (testNum / 10 > 0):
                numberList.append(testNum % 10)
                testNum = testNum / 10
            numberList.append(testNum)
            ret = 0
            for num in numberList:
                ret = ret + num * num 
            if ret in wrongNum:
                return False
            testNum = ret
            wrongNum.append(ret)
        return True

def main():
    solution = Solution()
    print str(solution.isHappy(7))

if __name__ == '__main__':
    main()
