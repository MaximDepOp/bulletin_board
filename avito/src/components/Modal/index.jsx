import React from "react";
import clsx from "clsx";
import styles from "./Modal.module.scss";

export const Modal = ({ children, active, setActive, className }) => {
  return (
    <div
      className={active ? clsx(styles.modal, styles.active) : styles.modal}
      onClick={() => setActive(false)}
    >
      <div
        className={
          active
            ? clsx(className, styles.modal__content, styles.active)
            : styles.modal__content
        }
        onClick={(e) => e.stopPropagation()}
      >
        {children}
      </div>
    </div>
  );
};
