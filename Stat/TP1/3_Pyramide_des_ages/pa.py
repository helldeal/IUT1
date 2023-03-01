import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv('pyramide_ages.csv', sep=',',decimal=',')

def ex1_3_1():
    print(data.columns)
    print(data['age'])
    print(data[data['age']<60])

def ex1_3_2():
    fig, axes = plt.subplots(1,1)
    # On trace deux barres horizontales
    axes.barh(y=1, width = 3, height = 0.5)
    axes.barh(y=2, width = 1, height = 0.5)
    plt.show()

def ex1_3_3():
    fig, axes = plt.subplots()
    axes.barh(data['age'],data['2019_F'],label='Femme')
    axes.barh(data['age'],-data['2019_H'],label='Homme')
    axes.legend()
    axes.set_title("Pyramide des ages de 2019")
    plt.show()

def ex1_3_4():
    fig, (axes0,axes1,axes2) = plt.subplots(1,3)
    axes0.barh(data['age'],data['1975_F'],label='Femme')
    axes0.barh(data['age'],-data['1975_H'],label='Homme')
    axes0.plot(data['1975_F']-data['1975_H'],data['age'],label="Différence",color="green")
    axes0.set_title("1975")
    axes0.set_ylabel('Age', loc='top')
    axes0.set_xlabel('Pop', loc='left')
    axes0.spines['left'].set_position('zero')
    axes0.spines['right'].set_color('none')
    axes0.spines['top'].set_color('none')
    axes0.set_ylim(bottom=0)
    #axes0.set_xticks(list(range(-400000,400000)))
    #axes0.set_xticklabels([abs(y) for y in list(range(-400000,400000))])

    axes1.barh(data['age'],data['1999_F'],label='Femme')
    axes1.barh(data['age'],-data['1999_H'],label='Homme')
    axes1.plot(data['1999_F']-data['1999_H'],data['age'],label="Différence",color="green")
    axes1.set_title("1999")
    axes1.set_ylabel('Age', loc='top')
    axes1.set_xlabel('Pop', loc='left')
    axes1.spines['left'].set_position('zero')
    axes1.spines['right'].set_color('none')
    axes1.spines['top'].set_color('none')
    axes1.set_ylim(bottom=0)



    axes2.barh(data['age'],data['2019_F'],label='Femme')
    axes2.barh(data['age'],-data['2019_H'],label='Homme')
    axes2.plot(data['2019_F']-data['2019_H'],data['age'],label="Différence",color="green")
    axes2.set_title("2019")
    axes2.set_ylabel('Age', loc='top')
    axes2.set_xlabel('Pop', loc='left')
    axes2.spines['left'].set_position('zero')
    axes2.spines['right'].set_color('none')
    axes2.spines['top'].set_color('none')
    axes2.set_ylim(bottom=0)

    fig.suptitle("Pyramide des ages en France")
    axes1.legend(loc='lower center', bbox_to_anchor=(0.5, -0.2, 0., 0.5),ncol=3)
    fig.tight_layout()
    plt.show()


def main():
    ex1_3_1()
    ex1_3_2()
    ex1_3_3()
    ex1_3_4()

if __name__ == '__main__':
    main()