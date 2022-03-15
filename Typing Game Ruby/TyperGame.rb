
class TyperGame  

	@@wordArr = Array["ruby", "black", "contempt", "plane", "yellow", "turmoil", "execute", "perplexing", "airplane"]


	def initialize(gameSize)
		@gameSize = gameSize.to_i
		@instanceList = makeList()
	end

	def makeList()
		toReturn = Array.new()
		for i in 0...@gameSize
			int = rand(@@wordArr.size)
			toReturn.append(@@wordArr[int])
		end
		return toReturn
	end

	def playTerminal()
		displayWords(@instanceList)
		input = getInput()
		score = displayErrors(input)
		return score
	end

	def displayErrors(inputArr)
		toReturn = ""
		count = 0
		range = @instanceList.size > inputArr.size ? inputArr.size : @instanceList.size
		for i in 0...range 
			if (@instanceList[i] != inputArr[i])
				toReturn += "[" + @instanceList[i] + " -> " + inputArr[i] + "], "
				count += 1
			end
		end
		puts "-------------------------------------\n\n"
		puts "Errors: " + count.to_s
		puts toReturn
		puts "\n-------------------------------------"
		return count
	end

	def displayWords(toDisplayArr)
		toReturn = ""
		for i in toDisplayArr 
			toReturn += i + " "
		end
		puts "-------------------------------------\n\n"
		puts toReturn
		puts "\n-------------------------------------"
	end


	def getInput()
		userInput = gets 
		temp = ""
		toReturn = Array.new()
		for i in 0...userInput.size
			curr = userInput[i]
			if curr == " " || curr == "\n"
				toReturn.append(temp)
				temp = ""
			else
				temp += curr
			end
		end
		return toReturn
	end

end
