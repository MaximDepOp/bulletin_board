import React from "react";

import styles from "./Categories.module.scss";

const Categories = () => {
  return (
    <div className={styles.categories}>
      <ul>
        <li>
          <a href="/#">Личные вещи </a>
        </li>

        <li>
          <a href="/#">Транспорт</a>
        </li>
      </ul>

      <ul>
        <li>
          <a href="/#">Работа</a>
        </li>
        <li>
          <a href="/#">Автозапчасти и аксессуары </a>
        </li>
        <li>
          <a href="/#">Для дома и дачи </a>
        </li>
      </ul>

      <ul>
        <li>
          <a href="/#">Недвижимость</a>
        </li>
        <li>
          <a href="/#">Предложение услуг </a>
        </li>
        <li>
          <a href="/#">Хобби и отдых </a>
        </li>
      </ul>

      <ul>
        <li>
          <a href="/#">Электроника</a>
        </li>
        <li>
          <a href="/#">Животные </a>
        </li>

        <li>
          <a href="/#">Готовый бизнес и оборудование </a>
        </li>
      </ul>
    </div>
  );
};

export default Categories;
