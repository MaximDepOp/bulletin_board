import React, { useState } from "react";
import styles from "./Info.module.scss";
import { useLocation } from "react-router-dom";
import { Button } from "@components/Button";
import cn from "classnames";
import { GrView } from "react-icons/gr";

const Info = () => {
  const location = useLocation();
  const data = location.state;

  const [showPhone, setShowPhone] = useState(false);

  console.log(data);

  return (
    <div className={styles.info}>
      <div className={styles.left}>
        <h1 className={styles.name}>{data.name}</h1>
        <div className={styles.btns}>
          <Button color="gray" className={cn(styles.btn, styles.btnAdd)}>
            Добавить в избранное
          </Button>


          <Button color="gray" className={cn(styles.btn, styles.btnView)}>
            Добавить заметку
          </Button>

          <p>11 мая в 07:28</p>
        </div>
        <img src={data.imageUrlBig} alt="" />
      </div>
      <div className={styles.right}>
        <h1>360 000 ₽</h1>
        <p>36 000 ₽ за сотку</p>
        <Button
          color="green"
          onClick={() => setShowPhone(true)}
          className={styles.btnRight}
        >
          {showPhone === true ? (
            <p>8 000 000 00 00</p>
          ) : (
            <p>Показать телефон 8 XXX XXX-XX-XX</p>
          )}
        </Button>

        <Button color="blue" className={styles.btnRight}>
          Написать сообщение
        </Button>

        <div className={styles.where}>
          <a href="/#">АН Династия 24 - Новоалтайск</a>
          <p>Агентство</p>
          <Button color="gray" className={styles.btn}>
            Подписаться на продавца
          </Button>
          <div className={styles.contact}>
            <div>
              <p>Контактное лицо</p>
              <span>Алена Малевич</span>
            </div>
            <div className={styles.contact}>
              <p className={styles.views}>
                <GrView />
                169
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Info;
