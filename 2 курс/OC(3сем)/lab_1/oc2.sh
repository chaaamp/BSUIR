#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Использование: $0 <каталог>"
    exit 1
fi

directory="$1"

if [ ! -d "$directory" ]; then
    echo "Указанный каталог не существует."
    exit 1
fi

for file in "$directory"/*; do
    if [ -f "$file" ]; then
        # Если это файл, то выводим размер и права доступа
        file_size=$(stat -c "%s" "$file")
        file_permissions=$(stat -c "%a" "$file")
        echo "Файл: $file, Размер: $file_size байт, Права доступа: $file_permissions"
    elif [ -d "$file" ]; then
        # Если это директория, рекурсивно вызываем скрипт для этой директории
        "$0" "$file"
    fi
done
