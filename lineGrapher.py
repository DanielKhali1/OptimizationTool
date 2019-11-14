import pandas
from pandas import DataFrame
import matplotlib.pyplot as plt

csv_file = "test.csv"
df = pandas.read_csv(csv_file)

iterations = df['iteration']
optimizer1 = df['optimizer1']
optimizer2 = df['optimizer2']


#dataFrame.plot(x = 'optimizer1', y = 'iteration', kind = 'line')

plt.plot(optimizer1, iterations, label = 'GA', linewidth = 2, color = 'green')
plt.plot(optimizer2, iterations, label = 'PSO', linewidth = 2, color = 'red')
plt.legend()
plt.show()
