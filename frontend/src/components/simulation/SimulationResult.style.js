import styled from "styled-components";

const TabMenu = styled.ul`
  background-color: #dcdcdc;
  font-weight: bold;
  display: flex;
  flex-direction: row;
  justify-items: center;
  align-items: center;
  list-style: none;

  .submenu {
    width:100% auto;
    padding: 15px 10px;
    cursor: pointer;
  }
`;

const StatusBtn = styled.span`
  background-color: darkgray;
  color: white;
  margin: 0 1rem 1rem 0;
`



export {TabMenu, StatusBtn };