import React from "react";

import styles from "./Services.module.scss";
import home from "@assets/home.svg";

const Services = () => {
  return (
    <div className={styles.inner}>
      <div className={styles.s}>
        <div className={styles.card}>
          <img src={home} alt="" />

          <div className={styles.info}>
            <h2>Looking For</h2>
            <p>
            Электронная доска объявлений. 
            </p>
          </div>
        </div>
        <div className={styles.card}>
          <img src={home} alt="" />

          <div className={styles.info}>
            <h2>Авторы:</h2>
            <p>
              Абдуллаева Надежда, 494а
            </p>
            <p>
              Дорофеев Максим, 494а
            </p>
            <p>
              Абдуллаева Вера, 494а
            </p>
          </div>
        </div>
      </div>
      <div className={styles.captcha}>
        © ООО «DAA» 2022–2022
        <ul className={styles.list}>
        </ul>
      </div>
    </div>
  );
};

export default Services;
