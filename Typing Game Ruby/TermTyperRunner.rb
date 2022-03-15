
#require 'E:\Programming\Personal Projects\Ruby Programs\Typing game\TyperGame'
require 'Programming/Ruby\ Programs/Typing-Game/TyperGame'

puts "Welcome to Typer Ultimate - Terminal Version"
gameOn = true
size = 10
totalErrors = 0
totalWords = 0
score = 0

while gameOn
	puts "Enter \"start\" to begin a new game, \"quit\" to exit the program, or \"help\" for more options"
	input = gets.chomp
	if input == "start"
		game = TyperGame.new(size)
		puts "Game starts now!"
		totalErrors += game.playTerminal
		totalWords += size
		score = (totalWords.to_f - totalErrors.to_f) / totalWords.to_f
		puts "Your total score is " + (score * 100).to_i.to_s + "%\n\n"
	elsif input == "quit"
		gameOn = false
	elsif input == "help"
		help()
	else
		puts "Not a valid input"
	end
end

def help
	puts "Options: "
	puts "changeSize - change the default game size (size is " + size.to_s + " right now)"
	puts "ResetScore - reset the score across games to 0"
end

