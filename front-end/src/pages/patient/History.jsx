import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";
import PaginationComponent from "@/components/pagination";
import { useState } from "react";
import { patientHistory } from "@/data/tableHistoryPatient";


const history = () => {
    const ITEMS_PER_PAGE = 10;
    const [currentPage, setCurrentPage] = useState(1);

    // Usando o array importado diretamente
    const startIndex = (currentPage - 1) * ITEMS_PER_PAGE;
    const visibleItems = patientHistory.slice(startIndex, startIndex + ITEMS_PER_PAGE);
    const totalPages = Math.ceil(patientHistory.length / ITEMS_PER_PAGE);




    return (
        <div>
            <div className="min-h-[100vh] flex-1 rounded-xl bg-muted/50 md:min-h-min">
                 
                    <>
                        <Table>
                            <TableHeader>
                                <TableRow>
                                    <TableHead>médico</TableHead>
                                    <TableHead>data e horário da consulta</TableHead>
                                    <TableHead>descrição</TableHead>
                                    <TableHead>Especialidade</TableHead>
                                    <TableHead>Contato</TableHead>
                                    <TableHead>Posto</TableHead>
                                </TableRow>
                            </TableHeader>

                            <TableBody>
                                {visibleItems.map((item, index) => (
                                    <TableRow key={index}>
                                        <TableCell className="font-medium">{item.medico}</TableCell>
                                        <TableCell>{item.data}</TableCell>
                                        <TableCell>{item.descricao}</TableCell>
                                        <TableCell>{item.especialidade}</TableCell>
                                        <TableCell>{item.contato}</TableCell>
                                        <TableCell>{item.posto}</TableCell>
                                        
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                        
                        <PaginationComponent
                            currentPage={currentPage}
                            totalPages={totalPages}
                            onPageChange={setCurrentPage}
                        />
                    </>
            </div>
        </div>
    );
};

export default history;
