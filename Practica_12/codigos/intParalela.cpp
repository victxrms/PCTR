#include <thread>
#include <iostream>
#include <vector>
#include <stdlib.h>
#include <mutex>
#include <ctime>

void monteCarlo(long ptosHilo, int &totalAciertos, std::mutex &Lock)
{
    double x = 0;
    double y = 0;
    long aciertos = 0;

    for (int i = 0; i < ptosHilo; i++)
    {
        x = (static_cast<double>(rand()) / RAND_MAX);
        y = (static_cast<double>(rand()) / RAND_MAX);

        if (y <= (x * x))
            aciertos++;
    }

    Lock.lock();
    totalAciertos += aciertos;
    Lock.unlock();
}

int main()
{
    long nPuntos = 0;
    int nHilos = 1;
    int totalAciertos = 0;
    std::mutex Lock;

    std::cout << "Introduce el numero de puntos: ";
    std::cin >> nPuntos;

    std::cout << "Introduce el numero de hilos: ";
    std::cin >> nHilos;

    long ptosHilo = nPuntos / nHilos;
    int ptosFInal = ptosHilo + (nPuntos % nHilos);

    std::vector<std::thread> vHilos;

    clock_t start = clock();

    for (size_t i = 0; i < nHilos - 1; i++)
    {
        vHilos.push_back(std::thread(monteCarlo, (ptosHilo), std::ref(totalAciertos), std::ref(Lock)));
    }

    vHilos.push_back(std::thread(monteCarlo, (ptosFInal), std::ref(totalAciertos), std::ref(Lock)));

    for (size_t i = 0; i < nHilos; i++)
    {
        vHilos[i].join();
    }

    clock_t end = clock();

    double time = ((double)(end - start) / CLOCKS_PER_SEC);

    std::cout << "Tiempo: " << time  << " segundos\n";
    std::cout << "Valor aproximado = " << (static_cast<double>(totalAciertos) / nPuntos) << std::endl;
    std::cout << "Hebras: " << nHilos << std::endl;

    return 0;
}