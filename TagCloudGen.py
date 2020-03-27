from wordcloud import WordCloud, STOPWORDS
import matplotlib.pyplot as plt
import pandas as pd
import os
import csv

stopwords = set(STOPWORDS)
myList = []
comm_words = ""

def PreProcess(path):
    with open(path, 'rt') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
        for row in spamreader:
            print(type(row))
            print(row)
            myList.extend(row)
PreProcess('G:\\Projects\\Python\\CloudTagGenerator\\csv.csv')
print(myList)

for cuv in myList:
    #print(type(cuv))
    comm_words = comm_words + cuv + ' '

wordcloud = WordCloud(width = 800, height = 800,
    background_color ='white',
    stopwords = stopwords,
    min_font_size = 6).generate(comm_words)

plt.figure(figsize = (8, 8), facecolor = None)
plt.imshow(wordcloud)
plt.axis("off")
plt.tight_layout(pad = 0)

plt.show()
