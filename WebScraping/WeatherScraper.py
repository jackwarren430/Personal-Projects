import requests
from bs4 import BeautifulSoup

atlantaCoords = '33.75,-84.39'
url = "https://weather.com/en-BS/weather/today/l/" + atlantaCoords


#weatherHTML = requests.get(url).text

# file = open("AtlWeatherPage.txt", 'w')
# file.write(weatherHTML)
# file.close()

file = open("AtlWeatherPage.txt", 'r')
lines = file.readlines()
weatherHTML = ""

for line in lines:
	weatherHTML += line

page = BeautifulSoup(weatherHTML, 'html.parser')

locationTag = page.find('h1')
timeTag = locationTag.next_sibline

print(locationTag.text)
print(timeTag.text)



# for span in page.find_all('span'):
# 	print(span.text)

#print(page.prettify())
