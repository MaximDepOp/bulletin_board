import React, { useState } from "react";
import Select from "react-select";

import { Button } from "@components/Button";
import { Modal } from "@components/Modal";
import { Checkbox } from "@components/Checkbox";

import styles from "./Select.module.scss";
const options = [
  { value: "Barnaul", label: "Барнаул" },
  { value: "Novosibirsk", label: "Новосибирск" },
  { value: "Altai", label: "Алтайский Край" },
];

const customStyles = {
  container: () => ({
    position: "relative",
    zIndex: "10",
  }),
  control: () => ({
    width: 200,
    height: 50,
  }),
  dropdownIndicator: () => ({
    position: "absolute",
    right: 0,
    top: 5,
  }),
};

const SelectCustom = () => {
  const [firstPopup, setFirstPopup] = useState(false);
  const [secondePopup, setSecondePopup] = useState(false);

  return (
    <div className="container">
      <div className={styles.select}>
        <Select options={options} styles={customStyles} />
        <input type="text" className={styles.inputSearch} />
        {firstPopup && (
          <Modal
            active={firstPopup}
            setActive={setFirstPopup}
            className={styles.popup}
          >
            <Select options={options} />
            <div className={styles.search}>
              <Checkbox>Сначала в выбранном городе</Checkbox>
              <Button color="blue">Показать</Button>
            </div>
          </Modal>
        )}
        <input
          type="text"
          onClick={() => setFirstPopup(true)}
          placeholder="Город или регион"
        />

        {secondePopup && (
          <Modal
            active={secondePopup}
            setActive={setSecondePopup}
            className={styles.popupCity}
          >
            <h1>Радиус поиска</h1>
            <Select options={options} />
            <iframe
              className={styles.map}
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d152480.13667758065!2d83.42887591188773!3d53.334267041704244!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x42dda1e8c72eeeab%3A0xb0e7bbef8d87b503!2sBarnaul%2C%20Altai%20Krai%2C%20Russia!5e0!3m2!1sen!2skz!4v1653759096870!5m2!1sen!2skz"
              width="600px"
              height="450px"
              allowFullScreen=""
              loading="lazy"
              referrerPolicy="no-referrer-when-downgrade"
            />
            <div className={styles.search}>
              <Button>Показать</Button>
            </div>
          </Modal>
        )}

        <input
          type="text"
          onClick={() => setSecondePopup(true)}
          placeholder="Радиус"
        />

        <Button color="blue" className={styles.btnSearch}>
          Найти
        </Button>
      </div>
    </div>
  );
};

export default SelectCustom;
