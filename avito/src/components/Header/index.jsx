import React, { useState } from "react";
import { AiOutlineHeart } from "react-icons/ai";

import { Button } from "@components/Button";
import { Modal } from "@components/Modal";

import styles from "./Header.module.scss";
import Advt from "@ui/Advt";
import SelectCustom from "../Select";

const links = ["Looking for"];

export const Header = () => {
  const [open, setOpen] = useState(false);
  const [openAd, setOpenAd] = useState(false);

  return (
    <div className={styles.h}>
      <div className={styles.top}>
        <div className="container">
          <nav className={styles.nav}>
            <ul>
              {links.map((link, index) => (
                <li key={index}>
                  <a href="/#">{link}</a>
                </li>
              ))}
            </ul>

            <div className={styles.right}>
              <AiOutlineHeart />

              <Button color="outline" onClick={() => setOpen(true)}>
                Вход и регистрация
              </Button>

              {open && (
                <Modal active={open} setActive={setOpen}>
                  Регистрация
                  <input type="text" />
                </Modal>
              )}
              {openAd && (
                <Modal active={openAd} setActive={setOpenAd}>
                  Разместить объявление
                  <input type="text" />
                </Modal>
              )}

              <Button color="#E79E9C" onClick={() => setOpenAd(true)}>
                Разместить объявление
              </Button>
            </div>
          </nav>
        </div>
      </div>
      <Advt />
      <SelectCustom />
    </div>
  );
};
