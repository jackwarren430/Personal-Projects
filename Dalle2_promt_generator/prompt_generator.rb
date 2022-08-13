

result_types = {
  '1' => ['Photorealistic', '4k/8k', 'detailed']
  '2' => {},
  '3' => {},
  '4' => {},
  '5' => {}
}


result_types_table = {
  '1' => 'Picture',
  '2' => 'Painting',
  '3' => 'Digital art',
  '4' => '3D render',
  '5' => 'Illistration'
}

tags = []


puts "\nWhat kind of result would you like?\n"
result_types_table.each do |num, style|
  puts "#{style} (#{num})"
end

style = false
while !style
  style_input = gets.chomp
  if result_types_table[style_input]
    style = result_types_table[style_input]
  else
    puts "\nInvalid input (type number)\n"
  end
end

puts "\nEnter subject\n"
subject = gets.chomp

result_front = "#{style} of #{subject}"
tags.unshift(result_front)

result = tags.join('.')
puts "\nFinal result: #{result}."
