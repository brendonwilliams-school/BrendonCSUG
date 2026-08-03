#include <iostream>
#include <thread>
#include <chrono>

using namespace std;
using namespace std::chrono;

// Function for the first thread
void countUp()
{
    cout << "\nThread 1: Counting Up\n";

    for (int i = 0; i <= 20; i++)
    {
        cout << i << endl;
        this_thread::sleep_for(milliseconds(250));
    }
}

// Function for the second thread
void countDown()
{
    cout << "\nThread 2: Counting Down\n";

    for (int i = 20; i >= 0; i--)
    {
        cout << i << endl;
        this_thread::sleep_for(milliseconds(250));
    }
}

int main()
{
    cout << "======================================" << endl;
    cout << "   C++ Concurrency Counter Program" << endl;
    cout << "======================================" << endl;

    // Create the first thread
    thread thread1(countUp);

    // Wait until thread 1 finishes
    thread1.join();

    // Create the second thread
    thread thread2(countDown);

    // Wait until thread 2 finishes
    thread2.join();

    cout << "\nProgram completed successfully!" << endl;

    return 0;
}