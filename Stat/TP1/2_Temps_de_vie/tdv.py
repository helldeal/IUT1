import pandas as pd
import matplotlib.pyplot as plt
data = pd.read_csv('temps_de_vie.csv', sep=',')

fig, ax = plt.subplots()
plt.xticks(rotation=35,ha="right")
ax.hist(data['0'], bins=len(data['0']))
plt.tight_layout()
plt.show()