#include <iostream>
#include <fstream>
#include <filesystem>
#include <thread>
#include <vector>
#include <mutex>
#include <windows.h>
namespace fs = std::filesystem;

const int MAX_THREADS = 5;
std::mutex mtx;

void copy_file(const fs::path& src_path, const fs::path& dest_path) {
    try {
        // Копирование файла и его прав доступа
        fs::copy_file(src_path, dest_path, fs::copy_options::update_existing);

        // Вывод информации о процессе
        mtx.lock();
        std::cout << "PID: " << std::this_thread::get_id() << ", Copied: " << src_path << ", Bytes: " << fs::file_size(src_path) << std::endl;
        mtx.unlock();
    } catch (const std::exception& e) {
        mtx.lock();
        std::cerr << "Error copying " << src_path << ": " << e.what() << std::endl;
        mtx.unlock();
    }
}

void sync_directories(const fs::path& src_dir, const fs::path& dest_dir) {
    std::vector<std::thread> threads;

    if (!fs::exists(dest_dir)) {
        fs::create_directories(dest_dir);
    }

    for (const auto& entry : fs::directory_iterator(src_dir)) {
        if (fs::is_regular_file(entry)) {
            fs::path src_path = entry.path();
            fs::path dest_path = dest_dir / src_path.filename();

            // Запускаем новый поток для копирования файла
            threads.emplace_back(copy_file, src_path, dest_path);

            // Ограничиваем количество одновременно работающих потоков
            if (threads.size() >= MAX_THREADS) {
                for (auto& thread : threads) {
                    thread.join(); // Ожидаем завершения всех потоков
                }
                threads.clear();
            }
        }
    }

    // Ждем завершения оставшихся потоков
    for (auto& thread : threads) {
        thread.join();
    }
}

int main() {
    SetConsoleOutputCP(CP_UTF8);
    std::string src_dir, dest_dir;
    int max_threads;

    std::cout << "Введите исходный каталог: ";
    std::cin >> src_dir;

    std::cout << "\n"
                 "Введите каталог назначения: ";
    std::cin >> dest_dir;

    std::cout << "Введите максимальное количество потоков: ";
    std::cin >> max_threads;

    sync_directories(src_dir, dest_dir);

    return 0;
}
